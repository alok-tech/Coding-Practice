const request = require('request')
const  geocode = require('./utils/geocode')
const forecast = require('./utils/forecast')

const address = process.argv[2]

// request({url: url, json: true}, (error, response)=>{
//     //console.log(response.body);
//     //const data = JSON.parse(response.body);
//     //console.log(data.current);
//     if (error){
//         console.log('Unable to connect to Server');
//     }else if(response.body.error){
//         console.log('Unable to find location');
//     }else{
//         console.log(response.body.current.weather_descriptions[0] + ". It is currently " +response.body.current.temperature +' degrees out. It feels like '+response.body.current.feelslike+ ' degrees out');
//     }
// })

if(!address) {
    console.log('Please provide an Address');
}else{
    geocode(address, (error, {lattitude, longitude, location})=>{   // Object destrcuturing also
        if(error){
            return console.log(error);
        }
        forecast(lattitude, longitude, (error, foreCastData)=>{
            if(error){
                return console.log(error);
            }
            console.log(location);
            console.log(foreCastData);
        })
    })
}

