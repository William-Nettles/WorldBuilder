import { WorldInterface } from "./WorldInterface";

export interface LocationInterface {
    id?: number,
    name?: string,
    description?: string,
    world?: WorldInterface
    latitude?: number,
    longitude?: number,
    image?: string,
    type?: string,
    yearEstablished?: number,
    yearDestroyed?: number,
    isCapital?: boolean,
    isCoastal?: boolean,
    population?: number,
}