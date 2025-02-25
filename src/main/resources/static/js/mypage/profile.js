let regular = document.getElementsByName('regular')[0]
let contract = document.getElementsByName('contract')[0]
let employeeId = document.getElementById('employeeId')
let employeeName = document.getElementById('employeeName')
let hireDate = document.getElementById('hireDate')
let departmentName = document.getElementById('departmentName')
let email1 = document.getElementById('email1')
let email2 = document.getElementById('email2')
let address = document.getElementById('address')
let zipCode = document.getElementById('zipCode')
let phone1 = document.getElementById('phone1')
let phone2 = document.getElementById('phone2')
let phone3 = document.getElementById('phone3')
let position = document.getElementById('position')
let salary = document.getElementById('salary')
let bankName = document.getElementById('bankName')
let accountNum = document.getElementById('accountNum')

const setInfo = (data) => {
    if(data.employmentType === 'ET001') {
        regular.checked = true
    } else {
        contract.checked = true
    }

    employeeId.value = data.employeeId
    employeeName.value = data.employeeName
    hireDate.value = data.hireDate.split('T')[0]
    departmentName.value = data.departmentName
    email1.value = data.email.split('@')[0]
    email2.value = data.email.split('@')[1]
    address.value = data.address
    zipCode.value = data.zipCode
    phone1.value = data.phone.slice(0, 3)
    phone2.value = data.phone.slice(3, 7)
    phone3.value = data.phone.slice(7, 11)
    position.value = data.position
    salary.value = data.salary || '-'
    bankName.value = data.bankName
    accountNum.value = data.accountNum


}

const getProfileInfo = () => {
    const url = '/api/mypage/profile'
    fetch(url, {
        method: 'get',
        headers: {
            "Content-Type": "application/json",
        }
    }).then((data) => {
        return data.json()
    }).then((data) => {
        setInfo(data)
    })
}

getProfileInfo()
