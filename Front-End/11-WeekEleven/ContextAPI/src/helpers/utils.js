export function findItemByID(items, id) {
    let foundItem = items.find((item) => item.id === id)

    if (!foundItem) {
        items.some((item) => {
            if (item.subItems && item.subItems.length > 0) {
                foundItem = findItemByID(item.subItems, id)
                return foundItem != null            
            }
            return false
        })
    }
    return foundItem
}