import { LocationInterface } from "./LocationInterface";
import { WorldInterface } from "./WorldInterface";

export interface EventInterface {
    id?: number,
    name?: string,
    description?: string,
    world?: WorldInterface
    year?: number,
    location?: LocationInterface,
    image?: string,
    type?: string,
}