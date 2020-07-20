var fs = require("fs");

fs.writeFile('./data/test.csv', 'alok', function(err){
    console.log("created");
})