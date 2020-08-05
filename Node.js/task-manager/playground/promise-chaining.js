require('../src/db/mongoose')

const User = require('../src/models/user')


//5f2323ae442a7759c4c7fe15
// ObjectId("5f23237c95d5256bc08e6bc0")

// User.findByIdAndUpdate('5f23237c95d5256bc08e6bc0', {age: 1}).then((user)=>{
//     console.log(user);
//     return User.countDocuments({age: 1})
// }).then((result)=>{
//     console.log(result);
// }).catch((e)=>{
//     console.log(e);
// })

const updateAgeAndCount = async (id, age)=>{
    const user = await  User.findByIdAndUpdate(id, {age})
    const count = await User.countDocuments({age})
    return count;
}

updateAgeAndCount('5f23237c95d5256bc08e6bc0', 2).then((count)=>{
    console.log(count);
}).catch((error)=>{
    console.log(error);
})