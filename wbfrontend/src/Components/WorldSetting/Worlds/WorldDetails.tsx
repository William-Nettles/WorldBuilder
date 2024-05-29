import { useParams } from "react-router-dom";
import { WorldInterface } from "../../../Interfaces/WorldInterface";
import { useEffect, useState } from "react";
import { get } from "http";
import { getNotesByWorld, getWorld, postNote } from "../../../Global/apis";
import { Badge, Button, Container, InputGroup, ListGroup, Modal, Tab, Tabs } from "react-bootstrap";
import { NoteInterface } from "../../../Interfaces/NoteInterface";
import { Form } from "react-bootstrap";



export const WorldDetails: React.FC = () => {

    const {worldId} = useParams();
    const [show, setShow] = useState(false);
    const [note, setNote] = useState<NoteInterface>(
        {
            title: "",
            content: "",
            world: undefined,
        }
    );
    const [world, setWorld] = useState<WorldInterface>();
    const [notes, setNotes] = useState<NoteInterface[]>([]);

    const handleNewClose = () => setShow(false);
    const handleNewShow = () => setShow(true);
    const handleNewSave = () => {
        console.log(note);
        postNote(note);
        setNotes([...notes, note]);
        setShow(false);
    }

    
    // Fetch notes data
    useEffect(() => {
        async function fetchNotes() {
            try {
                const response = await getNotesByWorld(worldId as unknown as number);
                setNotes(Array.isArray(response) ? response : []);
                console.log(response);
            } catch (error) {
                console.error('Failed to fetch notes:', error);
                setNotes([]);
            }
        }
        fetchNotes();
    }, [worldId]);

    // Fetch world data
    useEffect(() => {
        async function fetchData() {
            setWorld(await getWorld(worldId as unknown as number));
            console.log(world);
        }
        fetchData();
    }, [worldId]);

    



    return (
        <>
        <div style={{width:"100%", height:"auto"}}>
            <Tabs style={{width:"100%", height:"auto"}}
                defaultActiveKey="home"
                id="uncontrolled-tab-example"
                className="mb-3"
                justify
                >
                <Tab eventKey="home" title="Home">
                    <Container style={{boxSizing:"border-box", width:"80%", height:"auto", color:'white', backgroundColor:"rgba(0,0,0,.65)", borderRadius:'20px', padding: '10px', backgroundImage:`url(${world?.splashImage})`, backgroundSize:"cover"}}>
                    <h1>{world?.name}</h1>
                    <h4>Genre: {world?.genre} | Visbility: {world?.isPublic ? "Public":"Private"} </h4>
                        <p>{world?.description}</p>
                    </Container>
                </Tab>
                <Tab eventKey="notes" title="Notes">
                    T<ListGroup variant="dark" as="ol" numbered>
           
                    <ListGroup.Item
                        as="li"
                        className="d-flex justify-content-between align-items-start"
                        variant="dark"
                    >
                        <div className="ms-2 me-auto">
                        <div className="fw-bold">New Note</div>
                        General World Note
                        </div>
                        <Badge bg="warning" pill>
                        <Button variant="warning" onClick={handleNewShow}>Create</Button>
                        </Badge>
                    </ListGroup.Item>
                    {notes.map(note => {
                        return (
                            <ListGroup.Item
                                as="li"
                                className="d-flex justify-content-between align-items-start"
                                variant="dark"
                            >
                                <div className="ms-2 me-auto">
                                    <div className="fw-bold">{note.title}</div>
                                    {note.content}
                                </div>
                                <Badge bg="warning" pill>
                                    {note.id}
                                </Badge>
                            </ListGroup.Item>
                        );
                    })}
                    </ListGroup>
                </Tab>
                <Tab eventKey="settings" title="Settings">
                    Tab content for Settings
                </Tab>
            </Tabs>
        
        
        </div>


        <Modal variant = "dark" show={show} onHide={handleNewClose}>
            <Modal.Header closeButton>
            <Modal.Title>Modal heading</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Form>
                <Form.Group className="mb-3" controlId="title">
                    <Form.Label>Title</Form.Label>
                    <Form.Control type="text" placeholder="Enter title" onChange={(e) => setNote({
                        ...note,
                        title: e.target.value, world : world as WorldInterface
                    })}/>
                </Form.Group>
                <Form.Group className="mb-3" controlId="content">
                    <Form.Label>Content</Form.Label>
                    <Form.Control as="textarea" rows={3} placeholder="Enter content" onChange={(e) => setNote({
                        ...note,
                        content: e.target.value, world: world as WorldInterface
                    })}/>
                </Form.Group>
                </Form>
                
                
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