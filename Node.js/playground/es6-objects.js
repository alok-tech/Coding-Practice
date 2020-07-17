const name = 'Alok'

const userAge = 28

const user = {
    name: name,
    age: userAge,
    location: 'Kanpur'
}


console.log(user);

// Object Destructuring

const product = {
    label : 'Red Notebook',
    price: 3,
    stock: 201,
    salePrice: undefined,
    rating: 4.2
}

const {label, stock} = product

const {label:productLabel, rating=5} = product
console.log(label);
console.log(stock);
console.log(productLabel);
console.log(rating);

