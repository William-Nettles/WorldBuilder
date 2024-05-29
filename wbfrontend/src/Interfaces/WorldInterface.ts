import { UserInterface } from "./UserInterface";

export interface WorldInterface {
    id?: number,
    name?: string,
    description?: string,
    user?: UserInterface
    image?: string,
    isPublic?: boolean,
    splashImage?: string,
    genre?: string,
}