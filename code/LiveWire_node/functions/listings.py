import ticketpy
from google.cloud import firestore

tm_client = ticketpy.ApiClient('n87GZFAnAmTRKvAmZfItTkRPAU9E0JbY')
db = firestore.Client()

pages = tm_client.events.find(
    classification_name='Music',
    country_code = "IE"
)

def find_price_range(event_prange):
    if len(event_prange) == 2:
        return [event_prange[0]['min'],event_prange[1]['max']]
    else:
        return []
    
event_no = 1
for page in pages:
    for event in page:
        doc_ref = db.collection('listings').document("event-{:04d}".format(event_no)).set({
            u'artists': event.name,
            u'startdate': event.local_start_date,
            u'starttime': event.local_start_time,
            u'locations': [i.name for i in event.venues],
            u'pricerange': find_price_range(event.price_ranges),
            u'status': event.status
        })
        event_no += 1
        if event_no == 50:
            break
    if event_no == 50:
        break




"""
# Then query for documents
users_ref = db.collection(u'users')

for doc in users_ref.stream():
    print(u'{} => {}'.format(doc.id, doc.to_dict()))
    
"""