import PersonInformation from "./PersonInformation";

const personListTypes = [
    {title: "Phone Numbers", fieldname: "phoneNumbers", labelField: "name", valueField: "number"},
    {title: "Addresses", fieldname: "addresses", labelField: "name", valueField: "address"},
    {title: "Emails", fieldname: "emails", labelField: "name", valueField: "email"}
]

const Person = (props) => {
    return (
        <div className="person">
            <div className="side">
                <img className="person-avatar" src={props.avatar} alt={props.name} />
                <h1 className="person-name">{props.name}</h1>
            </div>
            <div className="info">
                {personListTypes.map((listType) => {
                    return (
                        <PersonInformation listType={listType} personData={props}/>
                    )
                })}
            </div>
        </div>
    )    
};

export default Person