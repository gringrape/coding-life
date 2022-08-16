import axios from 'axios'

interface User {
  id: number
  name: string
  age: number
}

export default async function fetchUsers (): Promise<User[]> {
  const response = await axios.get('https://dummyjson.com/users')

  const { users } = response.data

  return users
}
