import { RaceInterface } from "./RaceInterface";
import { SubraceInterface } from "./SubraceInterface";

export interface CharacterInterface {
    id?: number,
    firstName?: string,
    lastName?: string,
    otherNames?: string,
    description?: string,
    age?: number,
    dateOfBirth?: string,
    dateOfDeath?: string,
    image?: string,
    sex?: string,
    height?: number,
    weight?: number,
    hairColor?: string,
    eyeColor?: string,
    race?: RaceInterface
    subrace?: SubraceInterface
}