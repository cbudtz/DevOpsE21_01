import { render, screen } from '@testing-library/react';
import App from './App';
import {MockGiraffeStore} from "./viewmodel/MockGiraffeStore";

test('renders add giraffe', () => {
  const mockGiraffeStore = new MockGiraffeStore();
  render(<App store={mockGiraffeStore} />);
  const linkElement = screen.getByText(/add giraffe/i);
  const title = screen.getByText(/Giraf Butikken/i);
  expect(linkElement).toBeInTheDocument();
  expect(title).toBeInTheDocument();
});
