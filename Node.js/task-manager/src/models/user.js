
const mongoose = require('mongoose')
const validator = require('validator') 
//Lets do Data Modeling
const User = mongoose.model('User', {
    name: {
        type: String,
        required: true,
        trim: true
    },
    password: {
        type: String,
        required: true,
        trim: true,
        minlength: 7,
        validate(value) {
            if(value.toLowerCase().includes('password')){
                throw new Error('Paswword contains password String')
            }
        }
    },
    email : {
        type: String,
        required: true,
        lowercase: true,
        validate(value) {
            if(!validator.isEmail(value)){
                throw new Error('Email is not valid')
            }
        },
        trim: true
    },
    age: {
        type: Number,
        default: 0,
        validate(value) {
            if(value < 0){
                throw new Error('Age must be a positive number')
            }
        }
    }
})

// const me = new User({
//     name: '   Khusi    ',
//     email: 'KHUSI@gmail.com   ',
//     password: 'phone890!'

// })

// me.save().then(()=>{
//     console.log(me);
// }).catch((error)=>{
//     console.log('Error!', error);
// })

module.exports = User