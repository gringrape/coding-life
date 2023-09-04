const eventSource = new EventSource('http://localhost:3000');

eventSource.onmessage = ({ data }) => {
  const { count } = JSON.parse(data);
  const element = document.getElementById("count");
  element.textContent = `count: ${count}`;
};
