const fetch = require("node-fetch");
var botId = 'sinchsandbox2';
var phoneNbr = '14255034047';
var bearerToken = '3S6BplztQ9';

// var url = 'https://us1.whatsapp.api.sinch.com/whatsapp/v1/' + botId + '/messages';
// var data = {
//   to: [phoneNbr],
//   message: {
//     type: 'template',
//     template_name: 'sinch_tutorial',
//     params: ['Alok']
//   }
// };

// var postReq = {
//   method: 'POST',
//   headers: {
//     'Authorization': 'Bearer ' + bearerToken,
//     'Content-Type': 'application/json'
//   },
//   body: JSON.stringify(data),
//   json: true
// };

// fetch(url, postReq)
//   .then(data => {
//     return data.json()
//   })
//   .then(res => {
//     console.log(res)
//   })
//   .catch(error => console.log(error));

var url = 'https://us1.whatsapp.api.sinch.com/whatsapp/v1/' + botId + '/messages';
var data = {
  to: [phoneNbr],
  message: {
    type: 'text',
    text: 'Greetings from Sinch on behalf of Alok'
  }
};

var postReq = {
  method: "POST",
  headers: {
    'Authorization': 'Bearer ' + bearerToken,
    'Content-Type': 'application/json'
  },
  body: JSON.stringify(data),
  json: true
};


fetch(url, postReq)
  .then(data => {
    return data.json()
  })
  .then(res => {
    console.log(res)
  })
  .catch(error => console.log(error));