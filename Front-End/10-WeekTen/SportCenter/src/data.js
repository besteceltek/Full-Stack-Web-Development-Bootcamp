import yogaImage from './assets/yoga.jpg'
import groupImage from './assets/group.webp'
import soloImage from './assets/solo.jpg'
import stretchingImage from './assets/stret.webp'

export const statistics = [
    {number: 325, text: "Course"},
    {number: 405, text: "Work Out"},
    {number: 305, text: "Working Hour"},
    {number: 705, text: "Happy Client"},
]

export const classes = [
    {
        name: "yoga",
        header: "Yoga",
        description: "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Quia error iure incidunt dolorum adipisci? Maiores porro ex, placeat itaque exercitationem velit, vitae cumque, rerum obcaecati repellendus iste! Illum, labore animi?",
        image: yogaImage,
        classTime: [
            {
                days: "Saturday-Sunday",
                hours: "8:00am - 10:00am"
            },
            {
                days: "Monday-Tuesday",
                hours: "10:00am - 12:00pm"
            },
            {
                days: "Wednesday-Friday",
                hours: "3:00pm - 6:00pm"
            },
        ]
    },
    {
        name: "group",
        header: "Group",
        description: "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Quia error iure incidunt dolorum adipisci? Maiores porro ex, placeat itaque exercitationem velit, vitae cumque, rerum obcaecati repellendus iste! Illum, labore animi?",
        image: groupImage,
        classTime: [
            {
                days: "Saturday-Sunday",
                hours: "8:00am - 10:00am"
            },
            {
                days: "Monday-Tuesday",
                hours: "10:00am - 12:00pm"
            },
            {
                days: "Wednesday-Friday",
                hours: "3:00pm - 6:00pm"
            },
        ]
    },
    {
        name: "solo",
        header: "Solo",
        description: "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Quia error iure incidunt dolorum adipisci? Maiores porro ex, placeat itaque exercitationem velit, vitae cumque, rerum obcaecati repellendus iste! Illum, labore animi?",
        image: soloImage,
        classTime: [
            {
                days: "Saturday-Sunday",
                hours: "8:00am - 10:00am"
            },
            {
                days: "Monday-Tuesday",
                hours: "10:00am - 12:00pm"
            },
            {
                days: "Wednesday-Friday",
                hours: "3:00pm - 6:00pm"
            },
        ]
    },
    {
        name: "stretching",
        header: "Stretching",
        description: "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Quia error iure incidunt dolorum adipisci? Maiores porro ex, placeat itaque exercitationem velit, vitae cumque, rerum obcaecati repellendus iste! Illum, labore animi?",
        image: stretchingImage,
        classTime: [
            {
                days: "Saturday-Sunday",
                hours: "8:00am - 10:00am"
            },
            {
                days: "Monday-Tuesday",
                hours: "10:00am - 12:00pm"
            },
            {
                days: "Wednesday-Friday",
                hours: "3:00pm - 6:00pm"
            },
        ]
    },
]




export const personListTypes = [
    {title: "Phone Numbers", fieldname: "phoneNumbers", labelField: "name", valueField: "number"},
    {title: "Addresses", fieldname: "addresses", labelField: "name", valueField: "address"},
    {title: "Emails", fieldname: "emails", labelField: "name", valueField: "email"}
]



/*
<div class="content active" id="yoga">
    <div class="yoga-info">
        <h3>Yoga Classes</h3>
        <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Quia error iure incidunt dolorum adipisci? Maiores porro ex, placeat itaque exercitationem velit, vitae cumque, rerum obcaecati repellendus iste! Illum, labore animi?</p>
        <h3>When is the Class Time?</h3>
        <ul>
            <li>Saturday-Sunday: 8:00am - 10:00am</li>
            <li>Monday-Tuesday: 10:00am - 12:00pm</li>
            <li>Wednesday-Friday: 3:00pm - 6:00pm</li>
        </ul>
    </div>
    <div class="yoga-image">
        <img src="/images/yoga.jpg" alt="">
    </div>
</div>
*/