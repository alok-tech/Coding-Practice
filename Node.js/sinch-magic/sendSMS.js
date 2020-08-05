var request = require('request');
var options = {
  'method': 'POST',
  'url': 'https://us.sms.api.sinch.com/xms/v1/a9ef7fb846da4971b2c73057e27509e6/batches',
  'headers': {
    'Accept': 'application/json',
    'Content-Type': 'application/json',
    'Authorization': 'Bearer 9461e72da7d348718ec06af0d427505d'
  },
  body: JSON.stringify({"to":["919886709218", "918722123007"],"from":"447537432321","body":"Hello From Alok"})

};
request(options, function (error, response) {
  if (error) throw new Error(error);
  console.log(response.body);
});


//  "body": "This is a test message from your Sinch account" -- We can not modify this for trail Accounts