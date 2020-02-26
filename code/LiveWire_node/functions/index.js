// The Cloud Functions for Firebase SDK to create Cloud Functions and setup triggers.
const functions = require('firebase-functions'); // needed for all firebase functions
const admin = require('firebase-admin'); //needed to access cloud firestore
admin.initializeApp();


// [START addMessageTrigger]
exports.addMessage = functions.https.onRequest(async (req, res) => {
// [END addMessageTrigger]

  // Grab the text parameter.
  const original = req.query.text;
  
  // [START adminSdkAdd]
  // Push the new message into Cloud Firestore using the Firebase Admin SDK.
  const writeResult = await admin.firestore().collection('listings').add({original: original});
  // Send back a message that we've succesfully written the message
  res.json({result: `Message with ID: ${writeResult.id} added.`});
  // [END adminSdkAdd]
});

exports.sendWelcomeEmail = functions.auth.user().onCreate((user) => {

});