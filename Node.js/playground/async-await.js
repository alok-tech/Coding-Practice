const add = (a, b)=>{
    return new Promise((resolve, reject)=>{
        setTimeout(()=>{
            if(a < 0 || b < 0){
                return reject('Number must be non negative')
            }
            resolve(a+b)
        }, 2000)
    })
}


// Removes Promise Chaining
// All the variables are availabe in the scope.
const doWork = async ()=>{
    //throw new Error('Something went wrong')
    //return 'Alok'
    const sum = await add(1, 99)
    const sum2 = await add(100, 50)
    const sum3 = await add(sum2, 3)
    // Promise will be rejected in below case
    //const sum3 = await add(sum2, -3)
    return sum3
}

//console.log(doWork())

doWork().then((data)=>{
    console.log(data);
}).catch((error)=>{
    console.log(error);
});