import { CharacterInterface } from "../../../Interfaces/CharacterInterface";

export const CharacterCard: React.FC<CharacterInterface> = (character: CharacterInterface) => {
    return (
        <div>
        <h1>CharacterCard</h1>
            <p>Welcome to the CharacterCard page</p>
        </div>
    );
}