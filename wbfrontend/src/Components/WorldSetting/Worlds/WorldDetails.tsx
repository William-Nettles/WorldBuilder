import { Form, useParams } from "react-router-dom";
import { WorldInterface } from "../../../Interfaces/WorldInterface";
import { useEffect, useState } from "react";
import { get } from "http";
import { getNotesByWorld, getWorld } from "../../../Global/apis";
import { Badge, Button, Container, InputGroup, ListGroup, Modal } from "react-bootstrap";
import { NoteInterface } from "../../../Interfaces/NoteInterface";



export const WorldDetails: React.FC = () => {

    const {worldId} = useParams();
    const [show, setShow] = useState(false);
    const [note, setNote] = useState<NoteInterface>(
        {
            title: "",
            content: "",
            worldId: worldId as unknown as number
        }
    );
    const handleNewClose = () => setShow(false);
    const handleNewShow = () => setShow(true);
    const handleNewSave = () => {
        


        setShow(false);
    }

    
    const [world, setWorld] = useState<WorldInterface>();
    const [notes, setNotes] = useState<NoteInterface[]>([]);

    useEffect(() => {
        async function fetchNotes() {
            try {
                setNotes(await getNotesByWorld(worldId as unknown as number));
            } catch (error) {
                console.error('Failed to fetch notes:', error);
            }
        }
        fetchNotes();
    }, [worldId]);

    useEffect(() => {
        async function fetchData() {
            setWorld(await getWorld(worldId as unknown as number));
        }
        fetchData();
    }, [worldId]);

    useEffect(() => {
        console.log(note);
       
    }, [note]);



    return (
        <>
        <div>
        <Container style={{color:'white', backgroundColor:"rgba(0,0,0,.65)", borderRadius:'20px', padding: '10px'}}>
        <h1>{world?.name}</h1>
            <p>{world?.description}</p>
        </Container>
        <ListGroup variant="dark" as="ol" numbered>
           
            <ListGroup.Item
                as="li"
                className="d-flex justify-content-between align-items-start"
                variant="dark"
            >
                <div className="ms-2 me-auto">
                <div className="fw-bold">Subheading</div>
                Cras justo odio
                </div>
                <Badge bg="warning" pill>
                <Button variant="warning" onClick={handleNewShow}>Button</Button>
                </Badge>
            </ListGroup.Item>
            {notes.map(note => {
                return (
                    <ListGroup.Item
                        as="li"
                        className="d-flex justify-content-between align-items-start"
                    >
                        <div className="ms-2 me-auto">
                            <div className="fw-bold">{note.title}</div>
                            {note.content}
                        </div>
                        <Badge bg="primary" pill>
                            {note.id}
                        </Badge>
                    </ListGroup.Item>
                );
            })}
            </ListGroup>
        </div>


        <Modal variant = "dark" show={show} onHide={handleNewClose}>
            <Modal.Header closeButton>
            <Modal.Title>Modal heading</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <InputGroup size="sm" className="mb-3">
                <InputGroup.Text id="inputGroup-sizing-sm">Title</InputGroup.Text>
                
                </InputGroup>
                <br />
                <InputGroup size="sm" className="mb-3">
                <InputGroup.Text id="inputGroup-sizing-sm">Contents</InputGroup.Text>
                
                </InputGroup>
            </Modal.Body>
            <Modal.Footer>
            <Button variant="secondary" onClick={handleNewClose}>
                Close
            </Button>
            <Button variant="primary" onClick={handleNewSave}>
                Save Changes
            </Button>
            </Modal.Footer>
        </Modal>

        </>
    );
}