// var sinchSms = require('sinch-sms')({
//     key: '7df1fd08-4cb9-4f52-a649-54e5667cf18d',
//     secret: 'Zp+5ozIBNUOQc1JNsCXMvw=='
// });

// sinchSms.send('+918722123007', 'Hello From Alok!').then(function(response) {
// //All good, response contains messageId
// console.log(response);
// }).fail(function(error) {
// // Some type of error, see error object
// console.log(error);
// });



var sinchAuth = require('sinch-auth');

var sinchSms = require('sinch-messaging');

var auth = sinchAuth("7df1fd08-4cb9-4f52-a649-54e5667cf18d", "Zp+5ozIBNUOQc1JNsCXMvw==");

sinchSms.sendMessage("+918722123007", "Hello world!");