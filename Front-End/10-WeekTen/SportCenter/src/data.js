import yogaImage from './assets/yoga.jpg'
import groupImage from './assets/group.webp'
import soloImage from './assets/solo.jpg'
import stretchingImage from './assets/stret.webp'
import trainer1 from './assets/trainer1.jpg'
import trainer2 from './assets/trainer2.jpg'
import trainer3 from './assets/trainer3.jpg'
import purchase1 from './assets/purchase1.jpg'
import purchase2 from './assets/purchase2.jpg'
import purchase3 from './assets/purchase3.jpg'
import purchase4 from './assets/purchase4.jpg'

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

export const trainers = [
    {
        image: trainer1,
        name: "Jane Doe",
        class: "Fitness Trainer"
    },
    {
        image: trainer2,
        name: "Jane Doe",
        class: "Fitness Trainer"
    },
    {
        image: trainer3,
        name: "Jane Doe",
        class: "Fitness Trainer"
    }
]

export const purchases = [
    {
        image: purchase1,
        product: "Kettlebell / 5kg",
        price: "89,99",
        discount: "59,99",
    },
    {
        image: purchase2,
        product: "Treadmill",
        price: "899,99",
        discount: "599,99",
    },
    {
        image: purchase3,
        product: "Adjustable Dumbbell",
        price: "89,99",
        discount: "59,99",
    },
    {
        image: purchase4,
        product: "Kettlebell / 3kg",
        price: "89,99",
        discount: "59,99",
    }
]



export const personListTypes = [
    {title: "Phone Numbers", fieldname: "phoneNumbers", labelField: "name", valueField: "number"},
    {title: "Addresses", fieldname: "addresses", labelField: "name", valueField: "address"},
    {title: "Emails", fieldname: "emails", labelField: "name", valueField: "email"}
]