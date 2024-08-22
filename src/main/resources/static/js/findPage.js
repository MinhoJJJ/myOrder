$(document).ready(function() {
    function readFile(file, contentId) {
        var reader = new FileReader();
        reader.onload = function(e) {
            $('#' + contentId).val(e.target.result);
        };
        reader.readAsText(file);
    }

    $('#fileA').on('change', function(e) {
        readFile(this.files[0], 'contentA');
    });

    $('#fileB').on('change', function(e) {
        readFile(this.files[0], 'contentB');
    });

    $('#extractMessages').on('click', function() {
        var content = $('#contentA').val();
        if(content == null || content ==''){
            alert("비교할 jsp를 업로드해주세요.")
            return;
        }
        var matches = content.match(/<spring:message\s+code=(['"])([^'"]*)\1\s*\/>/g);
        if (matches) {
            $('#contentA-a').val(matches.join('\n'));
            $('#messageCount').text(matches.length);

        } else {
            $('#contentA-a').val('');
            $('#messageCount').text(0);

        }
    });
    let propertiesDataB = {};  // B 파일의 데이터를 저장할 객체

    $('#compareMessages').on('click', function() {
        var messagesContent = $('#contentA-a').val();
        var propertiesContent = $('#contentB').val();

        const file = $('#fileB')[0].files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = function(e) {
                const content = e.target.result;
                propertiesDataB = parseProperties(content);
                alert('B 파일이 로드되었습니다.');
                updateContentB();
            };
            reader.readAsText(file);
        } else {
            alert('파일을 선택해주세요.');
        }

        if (!messagesContent || !propertiesContent) {
            alert("비교할 jsp 파일과 properties 파일을 모두 업로드해주세요.");
            return;
        }

        // var matches = messagesContent.match(/<spring:message\s+code=(['"])([^'"]*)\1\s*\/>/g);
        // var keys = matches ? matches.map(match => match.match(/code=(['"])([^'"]*)\1/)[2]) : [];

        var matches = messagesContent.match(/<spring:message\s+code=(['"])([^'"]*)\1\s*\/>/g);
        var keys = matches ? matches.map(match => match.match(/code=(['"])([^'"]*)\1/)[2]) : [];

        var properties = propertiesContent.split('\n').map(line => {
            var parts = line.split('=');
            return {
                key: parts[0].trim(),
                value: parts[1] ? parts[1].trim() : ''
            };
        });

        $('#contentB-b').empty();

        var matchCount = 0;
        var mismatchCount = 0;

        keys.forEach(key => {
            var span = $('<span></span>')
                .text(key)
                .addClass('clickable-message')
                .data('code', key);
            var property = properties.find(p => p.key === key);
            if (property) {
                if (isUnicode(property.value)) {
                    span.addClass('blue-text');
                    matchCount++;

                    // 유니코드 값을 회색으로 표시
                    var unicodeText = unicodeToChar(property.value); // 유니코드를 한국어로 변환
                    span.append($('<span></span>').text(` (${unicodeText})`).css('color', 'gray')); // 변환된 텍스트를 회색으로 표시

                } else {
                    span.addClass('red-text');
                    mismatchCount++;
                }
            } else {
                span.addClass('red-text');
                mismatchCount++;
            }

            $('#contentB-b').append(span).append('<br>');
        });

        $('#matchCount').text(matchCount);
        $('#matchCount2').text(mismatchCount);

        keys.forEach(key => {
            var span = $('<span></span>')
                .text(`<spring:message code='${key}'/>`)
                .addClass('clickable-message') // 클릭 가능한 요소임을 나타내는 클래스 추가
                .data('code', key); // 데이터 속성에 code 값 저장

            var property = properties.find(p => p.key === key);

            if (property) {
                if (isUnicode(property.value)) {
                    span.addClass('blue-text');
                    matchCount++;

                    // 유니코드 값을 회색으로 표시
                    var unicodeText = unicodeToChar(property.value); // 유니코드를 한국어로 변환
                    span.append($('<span></span>').text(` (${unicodeText})`).css('color', 'gray')); // 변환된 텍스트를 회색으로 표시

                } else {
                    span.addClass('red-text');
                    mismatchCount++;
                }
            } else {
                span.addClass('red-text');
                mismatchCount++;
            }

            $('#contentB-b').append(span).append('<br>');
        });

        $('#matchCount').text(matchCount);
        $('#matchCount2').text(mismatchCount);

        // 클릭 이벤트 핸들러 추가
        $('.clickable-message').on('click', function() {
            var code = $(this).data('code');
            copyToClipboard(code);
        });
    });

    // 클립보드에 복사하는 함수 (이미 있다면 그대로 사용)
    function copyToClipboard(text) {
        const textArea = document.createElement("textarea");
        textArea.value = text;
        document.body.appendChild(textArea);
        textArea.select();
        document.execCommand("Copy");
        textArea.remove();
    }


    function isUnicode(str) {
        return /\\u[\dA-F]{4}/i.test(str);
    }

    function unicodeToChar(text) {
        return text.replace(/\\u[\dA-F]{4}/gi,
            function (match) {
                return String.fromCharCode(parseInt(match.replace(/\\u/g, ''), 16));
            });
    }

    function charToUnicode(text) {
        return text.split('').map(function (char) {
            return '\\u' + ('000' + char.charCodeAt(0).toString(16)).slice(-4);
        }).join('');
    }

    $('#convertUnicode').on('click', function() {
        var input = $('#unicodeInput').val();
        var output = '';

        if (isUnicode(input)) {
            output = unicodeToChar(input);
        } else {
            output = charToUnicode(input);
        }

        $('#unicodeOutput').val(output);
    });
    let propertiesData = {};

    $('#loadProperties').on('click', function() {
        const file = $('#propertiesFile')[0].files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = function(e) {
                const content = e.target.result;
                propertiesData = parseProperties(content);
                alert('Properties 파일이 로드되었습니다.');
                updateContentB();
            };
            reader.readAsText(file);
        } else {
            alert('파일을 선택해주세요.');
        }
    });
    $('#compareMessages2').on('click', function() {
        updateContentB();
    });

        function updateContentB() {
        $('#contentB-b .property-value').remove();
        $('#contentB-b .clickable-message').each(function() {
            const code = $(this).data('code');
            if (propertiesData[code]) {
                const unicodeText = unicodeToChar(propertiesData[code]);
                $(this).append($('<span></span>')
                    .text(` (${unicodeText})`)
                    .addClass('property-value')
                    .css('color', '#555'));
            }
        });
    }
    $('#searchProperty').on('click', function() {
        const key = $('#searchKey').val().trim();
        if (key in propertiesData) {
            const value = propertiesData[key];
            $('#koreanResult').text(unicodeToChar(value));
            $('#koreanUnicodeResult').text(value);
        } else {
            $('#koreanResult').text('찾을 수 없음');
            $('#koreanUnicodeResult').text('찾을 수 없음');
        }
    });

    function parseProperties(content) {
        const lines = content.split('\n');
        const data = {};
        lines.forEach(line => {
            const [key, value] = line.split('=').map(item => item.trim());
            if (key && value) {
                data[key] = value;
            }
        });
        return data;
    }

    function unicodeToChar(text) {
        return text.replace(/\\u[\dA-F]{4}/gi,
            function (match) {
                return String.fromCharCode(parseInt(match.replace(/\\u/g, ''), 16));
            });
    }
    function copyToClipboard(text) {
        const textArea = document.createElement("textarea");
        textArea.value = text;
        document.body.appendChild(textArea);
        textArea.select();
        document.execCommand("Copy");
        textArea.remove();
    }

    function searchByValue(value) {
        const normalizedValue = value.normalize('NFC');
        const results = [];
        for (const [key, propValue] of Object.entries(propertiesData)) {
            const decodedPropValue = unicodeToString(propValue);
            if (decodedPropValue === normalizedValue || propValue === normalizedValue) {
                results.push({ key, value: propValue, existsInB: key in propertiesDataB });
            }
        }
        return results;
    }

    function unicodeToString(str) {
        return str.replace(/\\u[\dA-F]{4}/gi, match =>
            String.fromCharCode(parseInt(match.replace(/\\u/g, ''), 16))
        ).normalize('NFC');
    }

    function stringToUnicode(str) {
        return str.split('').map(char =>
            '\\u' + ('000' + char.charCodeAt(0).toString(16)).slice(-4)
        ).join('');
    }

    $('#searchProperty2').on('click', function() {
        const value = $('#searchKey2').val();
        const results = searchByValue(value);
        if (results.length > 0) {
            $('#koreanResult').text(unicodeToString(results[0].value));
            $('#koreanUnicodeResult').text(results[0].value);

            const variableNamesHtml = results.map(result =>
                `<span class="${result.existsInB ? 'text-primary' : 'text-danger'}">${result.key}</span>`
            ).join(', ');
            $('#variableNames').html(variableNamesHtml);

            // Spring 메시지 태그 생성
            const springMessagesHtml = results.map((result, index) =>
                `<div class="mt-2 d-flex align-items-center">
                <code id="springMessage${index}">\"&lt;spring:message code='${result.key}' /&gt;\" &lt;%-- ${unicodeToString(result.value)} --%&gt;</code>
                <button class="btn btn-sm btn-secondary ms-2 copy-spring-message" data-index="${index}">복사</button>
            </div>`
            ).join('');

            // 새로운 div 요소 추가 (없다면)
            if ($('#springMessages').length === 0) {
                $('.result-container').append('<div id="springMessages" class="mt-3"></div>');
            }
            $('#springMessages').html(springMessagesHtml);
        } else {
            alert('해당 값을 찾을 수 없습니다.');
            $('#koreanResult').text('');
            $('#koreanUnicodeResult').text('');
            $('#variableNames').html('');
            $('#springMessages').html('');
        }
    });
// 새로 추가된 이벤트 핸들러
    $('#copyKorean').on('click', function() {
        copyToClipboard($('#koreanResult').text());
    });

    $('#copyKoreanUnicode').on('click', function() {
        copyToClipboard($('#koreanUnicodeResult').text());
    });

    $('#copyVariableNames').on('click', function() {
        copyToClipboard($('#variableNames').text());
    });

// 개별 Spring 메시지 복사 버튼 이벤트
    $(document).on('click', '.copy-spring-message', function() {
        const index = $(this).data('index');
        const springMessage = $(`#springMessage${index}`).text();
        copyToClipboard(springMessage);
    });

// 전체 Spring 메시지 복사 버튼은 유지
    $('.result-container').append('<button id="copyAllSpringMessages" class="btn btn-sm btn-secondary mt-2">모든 Spring 메시지 복사</button>');

    $('#copyAllSpringMessages').on('click', function() {
        const springMessages = Array.from($('#springMessages code')).map(code => code.textContent).join('\n');
        copyToClipboard(springMessages);
    });

    function copyToClipboard(text) {
        navigator.clipboard.writeText(text).then(() => {
            alert('클립보드에 복사되었습니다.');
        }).catch(err => {
            console.error('클립보드 복사 실패:', err);
        });
    }

// 파일 로드 및 내용 추출 함수
    function loadAndExtractProperties(fileId, contentId) {
        const file = document.getElementById(fileId).files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = function(e) {
                const content = e.target.result.split('\n');
                const properties = [];
                content.forEach(line => {
                    const [key, value] = line.split('=');
                    if (key && value) {
                        const trimmedKey = key.trim();
                        if (trimmedKey.includes('.')) {
                            const [, propertyName] = trimmedKey.split('.');
                            properties.push(propertyName);
                        }
                    }
                });
                document.getElementById(contentId).value = JSON.stringify(properties, null, 2);
                return properties;
            };
            reader.readAsText(file);
        }
    }

// 비교 함수
    function compareProperties() {
        // contentV와 contentV_1의 내용을 가져오기
        const contentV = document.getElementById('contentV').value;
        const contentV1 = document.getElementById('contentV_1').value;

        // 따옴표 안의 키들을 추출하기 위한 정규식
        const regex = /"([^"]+)"/g;

        // contentV에서 키 추출
        const propertiesZ = [];
        let match;
        while ((match = regex.exec(contentV)) !== null) {
            propertiesZ.push(match[1]);
        }

        // contentV_1에서 키 추출
        const propertiesX = [];
        while ((match = regex.exec(contentV1)) !== null) {
            propertiesX.push(match[1]);
        }

        let matchCount = 0;
        let mismatchCount = 0;
        const uniqueKeysInV = [];

        // contentV (propertiesZ)의 키가 contentV_1 (propertiesX)에 없는지 확인
        propertiesZ.forEach(key => {
            if (propertiesX.includes(key)) {
                matchCount++;
            } else {
                mismatchCount++;
                uniqueKeysInV.push(key);
            }
        });

        // 매칭 및 불일치 개수 표시
        document.getElementById('matchCountV').textContent = matchCount;
        document.getElementById('matchCountV2').textContent = mismatchCount;

        // contentV에만 있는 키들을 contentV_2에 한 줄에 하나씩 표시
        document.getElementById('contentV_2').value = uniqueKeysInV.join('\n');
    }

// 버튼 클릭 이벤트 리스너 등록
    document.getElementById('compareMessagesZ').addEventListener('click', () => {
        loadAndExtractProperties('fileZ', 'contentV');
    });

    document.getElementById('compareMessagesX').addEventListener('click', () => {
        loadAndExtractProperties('fileX', 'contentV_1');
    });

    document.getElementById('compare').addEventListener('click', compareProperties);
});