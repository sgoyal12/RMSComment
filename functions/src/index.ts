'use strict';
const functions = require('firebase-functions');
const admin = require('firebase-admin');
admin.initializeApp();
exports.countComment = functions.database.ref('/COMMENT/{comment_id}').onWrite(
async ((change:any)) => {
      const uid = change.after.child('userId');
    const countRef = admin.database().ref("/USER/"+uid+"/commentCount");

      let increment;
      if (change.after.exists() && !change.before.exists()) {
        increment = 1;
      } 
      else if (!change.after.exists() && change.before.exists()) {
        increment = -1;
      } 
      else {
        return null;
      }
      await countRef.transaction(((current:any)) => {
        return (current || 0) + increment;
      });
      console.log('Counter updated.');
      return null;
    });

