const express = require('express')
const path = require('path')
const hbs = require('hbs')
const geocode = require('./utils/geocode')
const forecast = require('./utils/forecast')

const app = express()

console.log(__dirname)

// Define paths for Express config
const publicDirectory = path.join(__dirname, '../public')
const viewPath = path.join(__dirname, '../templates/views')
const partialsPath = path.join(__dirname, '../templates/partials')

// Set up static directory to serve
app.use(express.static(publicDirectory))

// Setup handlebar engine nad views location
app.set('view engine','hbs')
app.set('views', viewPath)
hbs.registerPartials(partialsPath)


app.get('', (req, res)=>{
    res.render('index',{
        title: 'Weather App',
        name:'Alok'
    })
})

app.get('/help', (req, res)=>{
    res.render('help', {
        helpText : 'This is some helpful text',
        title: 'Help',
        name:'Alok'
    })
})

app.get('/about', (req, res)=>{
    res.render('about', {
        title: 'About me',
        name: 'Alok'
    })
})

app.get('/weather', (req, res)=>{
    if(!req.query.address) {
        return res.send({
            error: 'You must provide and address'    
        })
    }
    geocode(req.query.address, (error, {lattitude, longitude, location} = {})=>{   // Object destrcuturing also
        if(error){
            return res.send({
                error    
            })
        }
        forecast(lattitude, longitude, (error, foreCastData)=>{
            if(error){
                return res.send({
                    error    
                })
            }
            res.send({
                location,
                foreCastData,
                address: req.query.address
            })
            //console.log(location);
            //console.log(foreCastData);
        })
    })
})

app.get('/help/*', (req, res)=>{
    res.render('404', {
        title: '404',
        name: 'Alok',
        errorMessage: 'Help Article Not found'
    })
})
app.get('*', (req, res)=>{
    res.render('404', {
        title: '404',
        name: 'Alok',
        errorMessage: 'Page Not found'
    })
})
app.listen(3000, ()=>{
    console.log('Server is up on port 3000');
})
//app.com
// app.com/help
// app.com/about




