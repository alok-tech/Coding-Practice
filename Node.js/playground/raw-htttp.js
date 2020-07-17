const https = require('http')

const url = 'http://api.weatherstack.com/current?access_key=71ce35f6df4c15978751bbc164c2df3b&query=40.0115,-75.1327&units=f';

const request = https.request(url, (response)=>{
    let data = ''
    response.on('data', (chunk)=>{
        data = data + chunk.toString();
    })

    response.on('end', ()=>{
        const body = JSON.parse(data)
        console.log(body);
    })

    response.on('error', (error)=>{
        console.log('An Error', error);
    })
})

request.end()