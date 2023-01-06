package shop.tukoreamyway.back.sample.member;

// @Slf4j
// @RestController
// @RequiredArgsConstructor
// @RequestMapping("api/members")
// public class MemberController {
//
//    private final MemberService memberService;
//
//    @PostMapping
//    public String save() {
//        memberService.save();
//        return "good";
//    }
//
//    @GetMapping
//    public List<Member> getAll() {
//        long start = System.currentTimeMillis();
//        List<Member> result = memberService.getAll();
//        long end = System.currentTimeMillis();
//        log.info("{}", end - start);
//        return result;
//    }
//
//    @Cacheable(value = "post-test", cacheManager = "cacheManager")
//    @GetMapping("ch")
//    public List<Member> getAllCh() {
//        long start = System.currentTimeMillis();
//        List<Member> result = memberService.getAll();
//        long end = System.currentTimeMillis();
//        log.info("{}", end - start);
//        return result;
//    }
// }
