import { Button, Container, Col, Row } from "react-bootstrap";
import { Form } from "react-bootstrap";
import { useNavigate, useParams } from "react-router-dom";
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
    const { worldId} = useParams();
    const worldIdNumber = parseInt(worldId as string);
    const nav = useNavigate();
    const [newChar, setNewChar] = useState<CharacterInterface>();
    const [races, setRaces] = useState<RaceInterface[]>();
    const [subraces, setSubraces] = useState<SubraceInterface[]>();
   
    const handleSubmit = (e:any) => {
        e.preventDefault();
        setNewChar({...newChar, worldId: worldIdNumber});
        console.log(newChar);
            postCharacer(newChar).then((character) => {
                nav(`/world/${worldIdNumber}/characters/${character.id}`);
            }).catch((error) => {
                console.log(error);
            });        
    };

    

    

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
                    <Form.Control type="text" placeholder="Enter First Name" 
                    onChange={(input)=>setNewChar({...newChar, firstName: input.target.value})}/>
                </Form.Group>

                <Form.Group className="mb-3" controlId="name" >
                    <Form.Label>Last Name</Form.Label>
                    <Form.Control type="text" placeholder="Enter Last Name" 
                    onChange={(input)=>setNewChar({...newChar, lastName: input.target.value})}/>
                </Form.Group>
                <Form.Group className="mb-3" controlId="name" >
                    <Form.Label>Other Names</Form.Label>
                    <Form.Control type="text" placeholder="Enter Other Names" 
                    onChange={(input)=>setNewChar({...newChar, otherNames: input.target.value})}/>
                    <Form.Text className="text" color="white">
                        Enter any other names of your character
                    </Form.Text>
                </Form.Group>
                <Form.Group className="mb-3" controlId="desc" >
                    <Form.Label>Description</Form.Label>
                    <Form.Control type="text" placeholder="Enter Character Description"
                    onChange={(input)=>setNewChar({...newChar, description: input.target.value})} />
                </Form.Group>
                <Form.Group className="mb-3" controlId="desc" >
                    <Form.Label>Age</Form.Label>
                    <Form.Control type="number" placeholder="Enter Character Age" 
                    onChange={(input)=>setNewChar({...newChar, age: parseInt(input.target.value)})}/>
                </Form.Group>
                <Form.Group className="mb-3" controlId="desc" >
                    <Form.Label>Date of Birth</Form.Label>
                    <Form.Control type="text" placeholder="Enter Character DoB" 
                    onChange={(input)=>setNewChar({...newChar, dateOfBirth: input.target.value})}/>
                </Form.Group>
                <Form.Group className="mb-3" controlId="desc" >
                    <Form.Label>Date of Death</Form.Label>
                    <Form.Control type="text" placeholder="Enter Character DoD"
                    onChange={(input)=>setNewChar({...newChar, dateOfDeath: input.target.value})} />
                </Form.Group>
                <Button variant="warning" type="submit" onClick={()=>handleSubmit}>Submit</Button>
                <Button variant="warning" type="reset" onClick={()=>nav(`/world/${worldIdNumber}/characters`)}
                style={{margin:"5px"}}>Back</Button>
            </Col>
            <Col>
                <Form.Group className="mb-3" controlId="name" >
                    <Form.Label>Image</Form.Label>
                    <Form.Control type="text" placeholder="Enter Image Path" 
                    onChange={(input)=>setNewChar({...newChar, image: input.target.value})}/>
                </Form.Group>

                <Form.Group className="mb-3" controlId="name" >
                    <Form.Label>Sex</Form.Label>
                    <Form.Control as="select" placeholder="Enter Sex" 
                    onChange={(input)=>setNewChar({...newChar, sex: input.target.value})}>
                        <option value="male">male</option>
                        <option value="female">female</option>
                        </Form.Control>
                </Form.Group>
                <Form.Group className="mb-3" controlId="name" >
                    <Form.Label>Height</Form.Label>
                    <Form.Control type="number" placeholder="Enter Height" 
                    onChange={(input)=>setNewChar({...newChar, height: parseInt(input.target.value)})}/>
                </Form.Group>
                <Form.Group className="mb-3" controlId="desc" >
                    <Form.Label>Weight</Form.Label>
                    <Form.Control type="number" placeholder="Enter Weight" 
                    onChange={(input)=>setNewChar({...newChar, weight: parseInt(input.target.value)})}/>
                </Form.Group>
                <Form.Group className="mb-3" controlId="desc" >
                    <Form.Label>Hair Color</Form.Label>
                    <Form.Control type="text" placeholder="Enter Hair Color" 
                    onChange={(input)=>setNewChar({...newChar, hairColor: input.target.value})}/>
                </Form.Group>
                <Form.Group className="mb-3" controlId="desc" >
                    <Form.Label>Eye Color</Form.Label>
                    <Form.Control type="text" placeholder="Enter Character Eye Color" 
                    onChange={(input)=>setNewChar({...newChar, eyeColor: input.target.value})}/>
                </Form.Group>
                <Form.Group className="mb-3" controlId="desc" >
                    <Form.Label>Race</Form.Label>
                    <Form.Control as="select" placeholder="Enter Character Race"
                    onChange={(input)=>setNewChar({...newChar, raceName: input.target.value})}>
                        {races?.map (race => {return(<option value={race.name}> {race.name} </option>)})}
                        <option>None</option>
                    </Form.Control>
                        
                </Form.Group>
                <Form.Group className="mb-3" controlId="desc" >
                    <Form.Label>Subrace</Form.Label>
                    <Form.Control as="select" placeholder="Enter Character Subrace"
                    onChange={(input)=>setNewChar({...newChar, subraceName: input.target.value})}>
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