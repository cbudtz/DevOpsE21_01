export class MockGiraffeStore {
    giraffes =["Melman", "Elmer"]
    constructor() {

    }

    addGiraffe = (name)=>{
        this.giraffes.push(name)
    }
}