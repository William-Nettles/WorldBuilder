import { Button, Container, Col, Row } from "react-bootstrap";
import { Form } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { WorldInterface } from "../../Interfaces/WorldInterface";
import { useContext, useEffect, useRef, useState } from "react";
import { postCharacer, postWorld } from "../../Global/apis";
import { UserContext } from "../Contexts/UserContext";
import { UserInterface } from "../../Interfaces/UserInterface";
import { CharacterInterface } from "../../Interfaces/CharacterInterface";
import { RaceInterface } from "../../Interfaces/RaceInterface";
import { SubraceInterface } from "../../Interfaces/SubraceInterface";
//import { Container } from "react-bootstrap/Container";

export const BuildCharacter: React.FC = () => {

    const nav = useNavigate();
    const [newChar, setNewChar] = useState<CharacterInterface>();
    const [races, setRaces] = useState<RaceInterface[]>();
    const [subraces, setSubraces] = useState<SubraceInterface[]>();
   
    const handleSubmit = (e:any) => {
        
    };

    useEffect(() => {
        if (newChar?.firstName !== '') {
            console.log(newChar);
            postCharacer(newChar).then((character) => {
                nav(`/world/${character.id}`);
            }).catch((error) => {
                console.log(error);
            });
        }
    }, [newChar]);

    

    return (
        <div style={{color:'white', textAlign:'left'}}>
        <h1>BuildWorld</h1>
            <p>Welcome to the BuildWorld page</p>
            
            <Form onSubmit={handleSubmit}>
            <Container>
            <Row>
            <Col>
                <Form.Group className="mb-3" controlId="name" >
                    <Form.Label>First Name</Form.Label>
                    <Form.Control type="text" placeholder="Enter First Name" />
                </Form.Group>

                <Form.Group className="mb-3" controlId="name" >
                    <Form.Label>Last Name</Form.Label>
                    <Form.Control type="text" placeholder="Enter Last Name" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="name" >
                    <Form.Label>Other Names</Form.Label>
                    <Form.Control type="text" placeholder="Enter Other Names" />
                    <Form.Text className="text" color="white">
                        Enter any other names of your character
                    </Form.Text>
                </Form.Group>
                <Form.Group className="mb-3" controlId="desc" >
                    <Form.Label>Description</Form.Label>
                    <Form.Control type="text" placeholder="Enter Character Description" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="desc" >
                    <Form.Label>Age</Form.Label>
                    <Form.Control type="number" placeholder="Enter Character Age" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="desc" >
                    <Form.Label>Date of Birth</Form.Label>
                    <Form.Control type="text" placeholder="Enter Character DoB" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="desc" >
                    <Form.Label>Date of Death</Form.Label>
                    <Form.Control type="text" placeholder="Enter Character DoD" />
                </Form.Group>
                <Button variant="warning" type="submit">Submit</Button>
            </Col>
            <Col>
                <Form.Group className="mb-3" controlId="name" >
                    <Form.Label>Image</Form.Label>
                    <Form.Control type="text" placeholder="Enter Image Path" />
                </Form.Group>

                <Form.Group className="mb-3" controlId="name" >
                    <Form.Label>Sex</Form.Label>
                    <Form.Control type="text" placeholder="Enter Sex" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="name" >
                    <Form.Label>Height</Form.Label>
                    <Form.Control type="text" placeholder="Enter Height" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="desc" >
                    <Form.Label>Weight</Form.Label>
                    <Form.Control type="text" placeholder="Enter Weight" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="desc" >
                    <Form.Label>Hair Color</Form.Label>
                    <Form.Control type="number" placeholder="Enter Hair Color" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="desc" >
                    <Form.Label>Eye Color</Form.Label>
                    <Form.Control type="text" placeholder="Enter Character Eye Color" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="desc" >
                    <Form.Label>Race</Form.Label>
                    <Form.Control as="select" placeholder="Enter Character Race">
                        {races?.map (race => {return(<option> {race.name} </option>)})}
                        <option>None</option>
                    </Form.Control>
                        
                </Form.Group>
                <Form.Group className="mb-3" controlId="desc" >
                    <Form.Label>Subrace</Form.Label>
                    <Form.Control as="select" placeholder="Enter Character Subrace">
                        {subraces?.map (subrace => {return(<option> {subrace.name} </option>)})}
                        <option>None</option>
                    </Form.Control>
                        
                </Form.Group>
                </Col>
                </Row>
                </Container>
            </Form>
           
        
        </div>
    );
}