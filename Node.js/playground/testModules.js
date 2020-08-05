const add = require('./promise-chaining')

add(1, 3).then((sum)=>{
    console.log(sum);
}).catch((error)=>{
    console.log(error);
})