const fs = require('fs')
const chalk = require('chalk')
const getNotes = () =>{
  return "Your Notes...."  
}

const addNote = (title, body) =>{
    const notes = loadNotes();
    const dulicateNotes = notes.filter((note)=> note.title === title) // This looks to whole array even if A Match is founf
    const dulicateNote = notes.find((note)=> note.title === title)

    if(!dulicateNote){
        notes.push({
            title: title,
            body: body  
          })
        console.log(chalk.green.inverse('New Note Added'));
        saveNotes(notes)
    }else{
        console.log(chalk.red.inverse('Note Title Taken'));   
    }

}

const saveNotes = (notes)=> {
    const dataJSON = JSON.stringify(notes);
    fs.writeFileSync('notes.json', dataJSON)
}

const readNotes = (title)=> {
    const notes = loadNotes();
    const note = notes.find((note)=> note.title === title);

    if(note){
        console.log(chalk.inverse(note.title));
        console.log(note.body);
    }else{
        console.log(chalk.red.inverse('No Note found'));
    }
}

const removeNote = (title) =>{
    const notes = loadNotes();
    const notesToKeep = notes.filter((note)=> note.title != title)
    if(notes.length > notesToKeep.length){
        console.log(chalk.green.inverse('Note Removed'));
    }else{
        console.log(chalk.red.inverse('No Note found'));
    }
    saveNotes(notesToKeep)
}
const loadNotes = () =>{
    try {
        const dataBuffer = fs.readFileSync('notes.json')
        const dataJSON = dataBuffer.toString();
        return JSON.parse(dataJSON);
    }catch (e){
        return [];
    }
}

const listNotes = ()=>{
    const notes = loadNotes();
    
    if(notes.length === 0){
        console.log(chalk.red.inverse('No Notes found'));
    }else{
        notes.forEach(note => {
            console.log(chalk.green.inverse(note.title));
        });
    }
}

module.exports = {
    getNotes: getNotes,
    addNote: addNote,
    removeNote: removeNote,
    listNotes: listNotes,
    readNotes: readNotes
}