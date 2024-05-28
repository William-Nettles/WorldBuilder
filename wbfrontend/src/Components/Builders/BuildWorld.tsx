import { Button } from "react-bootstrap";
import { Form } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { WorldInterface } from "../../Interfaces/WorldInterface";
import { useContext, useEffect, useRef, useState } from "react";
import { postWorld } from "../../Global/apis";
import { UserContext } from "../Contexts/UserContext";
import { UserInterface } from "../../Interfaces/UserInterface";

export const BuildWorld: React.FC = () => {

    const nav = useNavigate();
    const [newWorld, setNewWorld] = useState({name: '', description: '', image: '', public: false, user: undefined} as WorldInterface);

    const formRef = useRef<HTMLFormElement>(null);
    const {currentUser} = useContext(UserContext);

    const nameRef = useRef<HTMLInputElement>(null);
    const descRef = useRef<HTMLInputElement>(null);
    const imgRef = useRef<HTMLInputElement>(null);
    const pubRef = useRef<HTMLInputElement>(null);
    const typeRef = useRef<HTMLSelectElement>(null);
    const handleSubmit = (e:any) => {
        e.preventDefault();
        const name = nameRef.current?.value;
        const desc = descRef.current?.value;
        const img = imgRef.current?.value;
        const pub = pubRef.current?.value;
        const type = typeRef.current?.value;
        setNewWorld({name: name, description: desc, type:type, image: img, isPublic: pub === 'on', user: currentUser as UserInterface});
    };

    useEffect(() => {
        if (newWorld.name !== '') {
            console.log(newWorld);
            postWorld(newWorld).then((world) => {
                nav(`/world/${world.id}`);
            }).catch((error) => {
                console.log(error);
            });
        }
    }, [newWorld]);

    

    return (
        <div style={{color:'white', textAlign:'left'}}>
        <h1>BuildWorld</h1>
            <p>Welcome to the BuildWorld page</p>
            <Form ref = {formRef} onSubmit={handleSubmit}>
                <Form.Group className="mb-3" controlId="name" >
                    <Form.Label>World Name</Form.Label>
                    <Form.Control type="text" placeholder="Enter World Name" ref = {nameRef}/>
                    <Form.Text className="text-muted">
                        Enter the name of your world
                    </Form.Text>
                </Form.Group>
                <Form.Group className="mb-3" controlId="desc" >
                    <Form.Label>World Description</Form.Label>
                    <Form.Control type="text" placeholder="Enter World Description" ref = {descRef}/>
                    <Form.Text className="text-muted">
                        Enter a description of your world
                    </Form.Text>
                </Form.Group>
                <Form.Group className = "mb-3" controlId="type" >
                    <Form.Label>World Type</Form.Label>
                    <Form.Control as="select" ref = {typeRef}>
                        <option>High Fantasy</option>
                        <option>Low Fantasy</option>
                        <option>Science Fiction</option>
                        <option>Historical</option>
                        <option>Modern</option>
                        <option>Post-Apocalyptic</option>
                    </Form.Control>
                    <Form.Text className="text-muted">
                        Select the type of your world
                    </Form.Text>
                </Form.Group>
                <Form.Group className="mb-3" controlId="img" >
                    <Form.Label>World Image</Form.Label>
                    <Form.Control type="text" placeholder="Enter World Image URL" ref={imgRef}/>
                    <Form.Text className="text-muted">
                        Enter the URL of an image for your world
                    </Form.Text>
                </Form.Group>
                <Form.Group className="mb-3" controlId="public">
                    <Form.Label>Make Public?</Form.Label>
                    <Form.Check type="checkbox" label="Check this box to make your world public" ref = {pubRef}/>
                </Form.Group>
                <Button variant="warning" type="submit">
                    Submit
                </Button>
            </Form>
        
        
        </div>
    );
}