import { EventInterface } from "../../../Interfaces/EventInterface";

export const EventCard: React.FC<EventInterface> = (event: EventInterface) => {
    return (
        <div>
        <h1>EventCard</h1>
            <p>Welcome to the EventCard page</p>
        </div>
    );
}