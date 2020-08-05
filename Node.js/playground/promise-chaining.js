const add = (a, b)=>{
    return new Promise((resolve, reject)=>{
        setTimeout(()=>{
            resolve(a+b)
        }, 2000)
    })
}
// add(1, 3).then((sum)=>{
//     console.log(sum);
// }).catch((error)=>{
//     console.log(error);
// })

// Say we have to have nested call to the function
// To much nesting is required
// add(1, 3).then((sum)=>{
//     add(4, sum).then((data)=>{
//         console.log(data);
//     }).catch((e)=>{
//         console.log(e);
//     })
// }).catch((error)=>{
//     console.log(error);
// })

// This is promise Chaining

add(1, 3).then((sum)=>{
    console.log(sum);
    return add(sum, 4)
}).then((sum1)=>{
    console.log(sum1);
}).catch((error)=>{
    console.log(error);
})

module.exports = add