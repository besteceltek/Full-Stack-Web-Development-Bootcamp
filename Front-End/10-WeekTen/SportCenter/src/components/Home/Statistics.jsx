
/*
const personListTypes = [
    {title: "Phone Numbers", fieldname: "phoneNumbers", labelField: "name", valueField: "number"},
    {title: "Addresses", fieldname: "addresses", labelField: "name", valueField: "address"},
    {title: "Emails", fieldname: "emails", labelField: "name", valueField: "email"}
]*/

function Statistics() {
    return (
        <div className="statistics">
            <div className="stat-block">
                <p className="numbers">325</p>
                <p className="texts">Course</p>
            </div>
            <div className="stat-block">
                <p className="numbers">405</p>
                <p className="texts">Work Out</p>
            </div>
            <div className="stat-block">
                <p className="numbers">305</p>
                <p className="texts">Working Hour</p>
            </div>
            <div className="stat-block">
                <p className="numbers">705</p>
                <p className="texts">Happy Client</p>
            </div>
        </div>
    )
}

export default Statistics