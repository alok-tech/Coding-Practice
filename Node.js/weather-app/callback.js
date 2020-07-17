setTimeout(() => {
    console.log('Two Seconds Pause');
}, 2000);


const geocode = (address, callback)=>{
    setTimeout(()=>{
        const data = {
            lattitude: 0,
            longitude: 0
        }
         callback(data);
    },2000)
}

//const data = geocode('Philedelphia');
// data comes undefined
//console.log(data);

geocode('Philedelphia', (value)=>{
    console.log(value)
})