require('../src/db/mongoose')

const Task = require('../src/models/task')

//5f216f38e171e570f4a2974d
Task.findByIdAndDelete('5f216f38e171e570f4a2974d').then((task)=>{
    console.log(task);
    return Task.countDocuments({completed : false})
}).then((result)=>{
    console.log(result);
}).catch((e)=>{
    console.log(e);
})

const deleteTaskAndCount = async (id)=>{
    const task = await Task.findByIdAndDelete(id)
    const count = await Task.countDocuments({completed : false})
    return count
}
//5f2aa7ad11b304572042590d
deleteTaskAndCount('5f2aa7ad11b304572042590d').then((count)=>{
    console.log(count);
}).catch((e)=>{
    console.log(e);
})