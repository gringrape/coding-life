import { createBrowserRouter } from 'react-router-dom';

import MainPage from './MainPage';
import ProblemPage from './ProblemPage';

const router = createBrowserRouter([
  {
    path: '/',
    element: <MainPage />,
  },
  {
    path: '/problem',
    element: <ProblemPage />,
  },
]);

export default router;
