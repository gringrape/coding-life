import fetchUsers from './services/fetchUsers'

import fixtures from './fixtures'

jest.mock('./services/fetchUsers')

interface User {
  id: number
  name: string
  age: number
}

type Condition = (user: User) => Boolean

async function findAllUsersByCondition (condition: Condition): Promise<User[]> {
  const users = await fetchUsers()

  return users.filter(condition)
}

describe('findAllUsersByCondition', () => {
  beforeEach(() => {
    (fetchUsers as jest.Mock).mockResolvedValue(fixtures.users)
  })

  it('returns users matching with conditions', async () => {
    const users = await findAllUsersByCondition((user) => user.age < 40)

    expect(users).toHaveLength(1)
  })
})
