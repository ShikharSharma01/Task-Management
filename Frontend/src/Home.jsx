import axios from "axios";
import { useState, useEffect } from "react";
function Home(){
    const[message, setMessage] = useState('');
    const url = "http://localhost:8080/home"
    
    const entry = async () => {
        try {
            var response = await axios.get(url);
            console.log(response.data);
            setMessage(response.data);
        } catch(error) {
            console.log(error);
        }
    }

    useEffect(() => {
        entry();
    },[]);
    
    return(
        <>
        <h2>{message}</h2>
        </>
    )
}

export default Home;