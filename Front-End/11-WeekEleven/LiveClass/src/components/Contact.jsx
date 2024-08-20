import { useEffect } from "react";

function Contact() {
    useEffect(() => {
        console.log("Component render oldu")
        return () => {
            console.log("Contact bizi terk etti")
        }
    }, [])
    return <div>Contact Component</div>
}

export default Contact