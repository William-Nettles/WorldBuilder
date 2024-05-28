import { UserInterface } from "./UserInterface";

export interface NoteInterface {
    title?: string,
    content?: string,
    user?: UserInterface,
    userId?: number,
    worldId?: number,
    id?: number,
    image?: string,
    date?: string,
    type?: string,
    pin?: string,
}