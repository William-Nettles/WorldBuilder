import { UserInterface } from "./UserInterface";
import { WorldInterface } from "./WorldInterface";

export interface NoteInterface {
    title?: string,
    content?: string,
    user?: UserInterface,
    userId?: number,
    world?: WorldInterface,
    id?: number,
    image?: string,
    date?: string,
    type?: string,
    pin?: string,
}