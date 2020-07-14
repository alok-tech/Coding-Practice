const notes = require('./notes')
const chalk = require('chalk')
const yargs = require('yargs')
const validator = require('validator')
const { argv } = require('process')

//const command = process.argv[2];

//Customize yargs version
yargs.version('1.1.0')

// Adding a Add command
yargs.command({
    command: 'add',
    describe: 'Add a new note',
    builder : {
        title: {
            description: 'Note Title',
            demandOption: true,
            type: 'string'
        },
        body: {
            description: 'Note Body',
            demandOption: true,
            type: 'string'
        }
    },
    handler(argv){
        notes.addNote(argv.title, argv.body)
    }
})

// Adding a Remove command
yargs.command({
    command: 'remove',
    describe: 'Remove a new note',
    builder : {
        title: {
            description: 'Note Title',
            demandOption: true,
            type: 'string'
        }
    },
    handler(argv){
       notes.removeNote(argv.title)
    }
})

// Adding a list command
yargs.command({
    command: 'list',
    describe: 'Listing out all notes',
    handler(){
        notes.listNotes();   
    }
})

// Adding a read command
yargs.command({
    command: 'read',
    describe: 'Reading a note',
    builder : {
        title: {
            description: 'Note Title',
            demandOption: true,
            type: 'string'
        }
    },
    handler(argv){
       notes.readNotes(argv.title)
    }
})

console.log(yargs.argv);

//if (command === 'add'){
    //console.log('Adding notes!');
    
//}else if(command === 'remove'){
    //console.log('Removing notes!');    
//}
//console.log(chalk.red.bold('Error'));
//console.log(process.argv[2]);


