const request = require('request')



const forecast = (lattitude, longitude, callback)=>{
    const url = 'http://api.weatherstack.com/current?access_key=71ce35f6df4c15978751bbc164c2df3b&query=40.0115,-75.1327&units=f';
    request({url, json: true}, (error, {body})=>{
        //console.log(response.body);
        //const data = JSON.parse(response.body);
        //console.log(data.current);
        if (error){
            callback('Unable to connect to Server');
        }else if(body.error){
            callback('Unable to find location');
        }else{
            callback(undefined, body.current.weather_descriptions[0] + ". It is currently " +body.current.temperature +' degrees out. It feels like '+body.current.feelslike+ ' degrees out')
        }
    })
}

module.exports = forecast
