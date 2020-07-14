// Arrow functions
const simplestSquare = (x)=> x*x;
// If one liner you don't need to return also

const square = (x)=>{
    return x*x;
}

// Above is equivalent to 
const funcSquare = function(x){
    return x*x;
}

// function defined itside an object bind themself with object's itself
// Arrow function don't bind themselves
const event = {
    name: 'Birthday Party',
    printGuestList: function (){
        console.log('Guest List for '+this.name);
    }
}

const event1 = {
    name: 'Birthday Party',
    printGuestList:  ()=>{
        console.log('Guest List for '+this.name);
    }
}

const event2 = {
    name: 'Birthday Party',
    guestList: ['Alok','Jeet','Brij'],
    printGuestList: function (){
        console.log('Guest List for '+this.name);
        this.guestList.forEach(function(guest){
            console.log(guest+' is attending '+this.name);
        })
    }
}
// Arrow function don't bind their own this value
// They access this value in the context in which they are
// created.
const event3 = {
    name: 'Birthday Party',
    guestList: ['Alok','Jeet','Brij'],
    printGuestList: function (){
        console.log('Guest List for '+this.name);
        this.guestList.forEach((guest)=>{
            console.log(guest+' is attending '+this.name);
        })
    }
}
//event.printGuestList();
// This will have undefine this context
//event1.printGuestList()
//event2.printGuestList()

event3.printGuestList()

