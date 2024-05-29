import axios from "axios";
import { WorldInterface } from "../Interfaces/WorldInterface";
import { NoteInterface } from "../Interfaces/NoteInterface";




//World APIs//////////////////////////////////////////////
//Get all worlds
export const getWorlds = async (): Promise<WorldInterface[]> => {
        const response = await fetch('http://localhost:8080/worlds');
        const data = await response.json();
        return data;
}
    
//Get world by id
export const getWorld = async (id: number): Promise<WorldInterface> => {
    const response = await fetch(`http://localhost:8080/worlds/${id}`);
    const data = await response.json();
    return data;
}

//Post new world
export const postWorld = async (world: WorldInterface): Promise<WorldInterface> => {
    const response = await fetch('http://localhost:8080/worlds', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(world),
    });
    const data = await response.json();
    return data;
}






//Notes Apis//////////////////////////////////////////////

//Get all notes
export const getNotesByWorld = async (worldId: number): Promise<NoteInterface[]> => {
    const response = await fetch(`http://localhost:8080/notes/world/${worldId}`);
    const data = await response.json();
    return data;
}

//Post new note
export const postNote = async (note: any): Promise<NoteInterface[]> => {
    const response = await fetch('http://localhost:8080/notes', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(note),
    });
    const data = await response.json();
    return data;
}

//Delete note
export const deleteNote = async (id: number): Promise<[]> => {
    const response = await fetch(`http://localhost:8080/notes/${id}`, {
        method: 'DELETE',
    });
    const data = await response.json();
    return data;
}

//Update note
export const updateNote = async (note: any): Promise<[]> => {
    const response = await fetch(`http://localhost:8080/notes/${note.id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(note),
    });
    const data = await response.json();
    return data;
}

//Get note by id
export const getNote = async (id: number): Promise<NoteInterface> => {
    const response = await fetch(`http://localhost:8080/notes/${id}`);
    const data = await response.json();
    return data;
}

//Get all notes
export const getNotes = async (): Promise<NoteInterface[]> => {
    const response = await fetch('http://localhost:8080/notes');
    const data = await response.json();
    return data;
}

//Get notes by world id and pin
export const getNotesByWorldAndPin = async (worldId: number, pin: string): Promise<NoteInterface[]> => {
    const response = await fetch(`http://localhost:8080/notes/world/${worldId}/pin/${pin}`);
    const data = await response.json();
    return data;
}

