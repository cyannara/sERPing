


// calendar
const Calendar = tui.Calendar;

const container = document.getElementById('calendar');

// const deptList = ''
// fetch()

const options = {
    defaultView: 'month',
    isReadOnly: false,
    timezone: {
        zones: [
            {
                timezoneName: 'Asia/Seoul',
                displayLabel: 'Seoul',
            },
        ],
    },
    theme: {
        // ...
    },
    calendars: [
        {
            id: 'cal1',
            name: '개인',
            backgroundColor: '#03bd9e',
        },
        {
            id: 'cal2',
            name: '부서',
            backgroundColor: '#00a9ff',
        },
    ],
    template: {
        // ...
    },
};

const calendar = new Calendar(container, options);

calendar.createEvents([
    {
        id: 'event1',
        calendarId: 'cal2',
        title: '주간 회의',
        start: '2025-02-07T09:00:00',
        end: '2025-02-07T10:00:00',
    },
    {
        id: 'event2',
        calendarId: 'cal1',
        title: '점심 약속',
        start: '2025-02-08T12:00:00',
        end: '2025-02-08T13:00:00',
    },
    {
        id: 'event3',
        calendarId: 'cal2',
        title: '휴가',
        start: '2025-02-08',
        end: '2025-02-10',
        isAllday: true,
        category: 'allday',
    },
]);

// 일정 생성 팝업을 사용하기 위해 tui-date-picker와 tui-time-picker의 css 파일을 불러온다.
// import 'tui-date-picker/dist/tui-date-picker.css';
// import 'tui-time-picker/dist/tui-time-picker.css';

calendar.setOptions({
    useFormPopup: true,
    useDetailPopup: true,
});

calendar.setTheme({
    common: {
        gridSelection: {
            backgroundColor: 'rgba(81, 230, 92, 0.05)',
            border: '1px dotted #515ce6',
        },
    },
});

function formatTime(time) {
    const hours = `${time.getHours()}`.padStart(2, '0');
    const minutes = `${time.getMinutes()}`.padStart(2, '0');

    return `${hours}:${minutes}`;
}

calendar.setOptions({
    template: {
        time(event) {
            const { start, end, title } = event;

            return `<span style="color: white;">${formatTime(start)}~${formatTime(end)} ${title}</span>`;
        },
        allday(event) {
            return `<span style="color: gray;">${event.title}</span>`;
        },
    },
});

// 인스턴스 이벤트 설정
calendar.on('beforeCreateEvent', (eventObj) => {
    // 이벤트 실행 시 인스턴스 메서드 활용
    calendar.createEvents([
        {
            ...eventObj,
            id: uuid(),
        },
    ]);
});

calendar.on('clickEvent', ({ event }) => {
    const el = document.getElementById('clicked-event');
    el.innerText = event.title;
});