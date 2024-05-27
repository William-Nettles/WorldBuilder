import { WorldInterface } from "./WorldInterface";

export interface MapInterface {
    id?: number,
    world?: WorldInterface
    name?: string,
    description?: string,
    image?: string,
    rootX?: number,
    rootY?: number,
}